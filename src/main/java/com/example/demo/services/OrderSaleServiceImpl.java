package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.OrderSaleDto;
import com.example.demo.models.CustomerEntity;
import com.example.demo.models.InvoiceEntiy;
import com.example.demo.models.LineSaleEntity;
import com.example.demo.models.OrderSaleEntity;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.LineSaleRepository;
import com.example.demo.repositories.OrderSaleRepository;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;

import org.apache.http.client.methods.*;

@Service
public class OrderSaleServiceImpl implements OrderSaleService{

	private OrderSaleRepository reposOrderSale;
	private CustomerRepository reposCustomer;
	private InvoiceRepository  reposInvoice;
	private LineSaleRepository reposLineSale;
    private ModelMapper mapper;
    
    
    @Autowired
    EmailService emailService;
    
    @Autowired
	public OrderSaleServiceImpl(OrderSaleRepository reposOrderSale, CustomerRepository reposCustomer, InvoiceRepository reposInvoice, LineSaleRepository reposLineSale , ModelMapper mapper) {
		super();
		this.reposOrderSale = reposOrderSale;
		this.reposCustomer = reposCustomer;
		this.reposInvoice = reposInvoice;
		this.reposLineSale = reposLineSale;
		this.mapper = mapper;
	}

	@Override
	public OrderSaleDto createOrderSale(OrderSaleDto OrderSale,int id) {
		OrderSaleEntity entity=mapper.map(OrderSale, OrderSaleEntity.class);
		CustomerEntity custEntity =reposCustomer.findById(id).get();
		entity.setCustomer(custEntity);
		InvoiceEntiy invoiceEntity = entity.getInvoice();
		InvoiceEntiy invoiceEntityInBd =reposInvoice.save(invoiceEntity);
		entity.setInvoice(invoiceEntityInBd);
		//entity.setTotalPrice(calculCommande(entity.getNumber()));
		
		OrderSaleEntity newEntity= reposOrderSale.save(entity);
		
		//Sending e-mail
//		emailService.sendMailOrder("khalilmeddeb2@gmail.com", "Commande");
		emailService.sendMailOrder(custEntity.getEmail(), "Commande");
		
		
		//Sending SMS
		
		/*NexmoClient client = NexmoClient.builder().apiKey("b0e8d5d6").apiSecret("R41T3arDUApUs34K").build();
		  TextMessage message = new TextMessage("Commande",
		                   "+21650944946",
		                    "Une commande vient d'etre passee"
		            );
		  
		  try {
			  SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
			  if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
			    System.out.println("Message sent successfully.");
			} else {
			    System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
			}
		  }
		  catch(Exception e) {}
			
		*/
		
		return mapper.map(newEntity, OrderSaleDto.class);
	}

	@Override
	public List<OrderSaleDto> getAllOrderSales() {
		 List<OrderSaleDto>listOrderSaleDto =new ArrayList<>();
	        List<OrderSaleEntity>listOrderSaleEntity=reposOrderSale.findAll();
	        for (OrderSaleEntity orderEntity : listOrderSaleEntity) {
	            listOrderSaleDto.add(mapper.map(orderEntity,OrderSaleDto.class));
	        }
	                return listOrderSaleDto;
	}

	@Override
	public OrderSaleDto getOrderSaleById(int id) {
		  OrderSaleEntity entity=reposOrderSale.findById(id).get();
	        return mapper.map(entity, OrderSaleDto.class);
	    }
	

	@Override
	public OrderSaleDto modifyOrderSale(int id, OrderSaleDto OrderSale) {
            OrderSaleEntity entity=reposOrderSale.findById(id).get();
	       // entity.setTotalPrice(OrderSale.getTotalPrice());
	        entity.setDate(OrderSale.getDate());
	        OrderSaleEntity newEntity=reposOrderSale.save(entity);
	        return mapper.map(newEntity, OrderSaleDto.class);
	    
	}

	@Override
	public void deleteOrderSaleById(int id) {
		reposOrderSale.deleteById(id);
				
	}
	////
	/////
	 //montant de la commande
	@Override
	public float calculCommande(int numero)
	{
		float somme = 0;
		OrderSaleEntity orderEntity=reposOrderSale.findById(numero).get();
		for (LineSaleEntity line : orderEntity.getLineSales()) {
			if(line.getProduct().getQuantite() > line.getQt())
			    {
			     somme += line.getQt()*line.getProduct().getPriceVente();
			     int res = line.getProduct().getQuantite()-line.getQt();
			     line.getProduct().setQuantite(res);
			     //reposLineSale.save(line);
			     
			    }
			else
			    {
				throw new ArithmeticException("unable to place an order");

			    }
		}
		orderEntity.setTotalPrice(somme);
		return somme;
		
	}
    
	//le revenu les ventes des produits dans le stock
	@Override
	public float getRevenuParMois(String mois) {
		List<OrderSaleEntity> orders = reposOrderSale.findAll();
		float revenu = 0;
		for (OrderSaleEntity orderSaleEntity : orders) {
			if (orderSaleEntity.getDate().toString().substring(5, 7).equals(mois)) {
				for(LineSaleEntity line : orderSaleEntity.getLineSales()) {
				
					revenu=(float) (revenu+((line.getProduct().getPriceVente())-(line.getProduct().getPriceAchat())) * line.getQt()
						);
				}
			}
			
		}
		return revenu;
		
	}
	  // le revenue des ventes des produits dans le stock par periode
	  @Override
	 	public float getRevenuParPeriode(LocalDate dateBegin, LocalDate dateEnd) {
	 		List<OrderSaleEntity>orders=reposOrderSale.findAll();
	 		float revenu=0;
	 		for (OrderSaleEntity order : orders) {
	 			if(order.getDate().isAfter(dateBegin) && order.getDate().isBefore(dateEnd)) {
	 				for(LineSaleEntity line : order.getLineSales()) {
	 					
						revenu=(float) (revenu+((line.getProduct().getPriceVente())-(line.getProduct().getPriceAchat())) * line.getQt()
							);
					}
	 				
	 				
	 			}
	 		}
	 		
	 		
	 		return revenu;
	 	}

}
