package util;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Stock;

/**
 * Serves as an IOT.
 * Rest Services that consume IEXTrading Stock data from IEX API Services
 * Reports to the StockWatcher app
 * 
 * @author Matthew & Joey
 *
 */
@Stateless
public class IotModerator
{
	/**
	 * Calls a GET IEX API to access stock data and POST to reporting app
	 * IEX Rest params: aapl/previous
	 * Scheduled to init every 5 seconds
	 * 
	 * {@link} stock/aapl/previous : IEX rest params
	 * {@link} stocks/previous : StockWatcher rest params
	 * 
	 */
    @Schedule(second="0", minute="*/1", hour="*", persistent=false)
    public void getIEX_Previous()
    {
    	// Opens a client
		Client client = ClientBuilder.newClient();
		// Initialize a channel
		Response response;
		
    	// -- GET from IEX API Service URL --
		String targetUrl = "https://api.iextrading.com/1.0/stock/aapl/previous";

		// Connects HTTP Response
		response = client.target(targetUrl).request().get();
		// Reads Json from HTTP page
		Stock stocks = response.readEntity(Stock.class);

		// -- POST to StockWatcher REST Service URL --
		targetUrl = "http://localhost:8080/StockWatcher/rest/stocks/previous";
		
		// Post Json
		response = client.target(targetUrl).request().post(Entity.entity(stocks, MediaType.APPLICATION_JSON));
		// Read Response Code from service
		System.out.println("\tStatus : " + response.getStatus());
		
		// Closes the Channel & Connection
		response.close();
		client.close();		
    }
}