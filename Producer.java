package com.amway.canonical.enterprise;
import org.apache.camel.builder.RouteBuilder;
public class Producer extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    //ProtobufDataFormat format = new ProtobufDataFormat(AddressBookProtos.getDefaultInstance());
	
	 
	 from("timer://marshal?period=10000")
    .marshal()
    .protobuf("com.amway.canonical.enterprise.AmGlEnterpriseEvent_Order_SalesOrder_SalesOrderEvent")
    .process(exchange->{
    	AmGlEnterpriseEventOrderSalesOrderSalesOrderEvent.addresses event =  AmGlEnterpriseEventOrderSalesOrderSalesOrderEvent.addresses.newBuilder()
  			  .setCareOfName("Jumper")
  			  .setCityName("vskp")
  			  .setEmailAddress("hello@gmail.com")
  			  .setId("123")
  			  .setIsoCountryCode("+91")
  	          .setLine1("123")
  	          .setLine2("234")
  	          .setLine3("456")
  	          .setLine4("789")
  	          .setPostalCode("123456")
  	          .setState("AP")
  	          .setTelephoneNumber("123456789")
  	          .setAlternateTelephoneNumber("987789987")
  			  .build();
    	exchange.getIn().setBody(event);
    })
    .log("${body}")
    .to("kafka:{{producer.topic}}");
    
  }
}
