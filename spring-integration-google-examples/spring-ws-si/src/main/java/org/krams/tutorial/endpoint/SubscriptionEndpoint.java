package org.krams.tutorial.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.oxm.AddListRequest;
import org.krams.tutorial.oxm.AddListResponse;
import org.krams.tutorial.oxm.Record;
import org.krams.tutorial.service.CommerceService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 * Handles subscription requests. 
 * <p>
 *<pre>
 * @Endpoint: similar to Spring MVC's @Controller. 
 * @PayloadRoot: similar to Spring MVC's @RequestMapping</pre>
 */
@Endpoint
public class SubscriptionEndpoint {

	protected static Logger logger = Logger.getLogger("endpoint");

	@Resource(name="commerceService")
	private CommerceService commerceService;
	
	// The namespace of both request and response as declared in the XSD file
	public static final String NAMESPACE_URI = "http://krams915.blogspot.com/ws/schema/oss";

	// The local name of the expected request.
	public static final String REQUEST_LOCAL_NAME = "addListRequest";

	/**
	 * Processes subscriptions. Actual processing is delegated to a service
	 * <p>
	 * In order for this method to be triggered, the localPart and namespace must
	 * match from the incoming XML request. This is exactly similar to Spring MVC.
	 * <p>
	 * In Spring MVC, we declare:
	 * <pre>@RequestMapping(value = "/admin", method = RequestMethod.GET)</pre>
	 * <p>
	 * In Spring WS, we declare:
	 * <pre>@PayloadRoot(localPart = "myRequest", namespace = "http://my.domain.com...")</pre>
	 */
	@PayloadRoot(localPart = REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
	@ResponsePayload
	public AddListResponse processSubscription( @RequestPayload AddListRequest genericRequest) {

		try {
			logger.debug("Received subscription request");
			
			try {
				logger.debug("Delegate to service");
				logger.debug("GenericRequest size: " + genericRequest.getRecord().size());
				
				for (Record record: genericRequest.getRecord()) {
					if (record.getSales() != null ) {
						commerceService.add(record.getSales());
					} 
					if (record.getInventory() != null ) {
						commerceService.add(record.getInventory());
					} 
					if (record.getOrder() != null ) {
						commerceService.add(record.getOrder());
					} 
				}
				
			}  catch (Exception e) {
				logger.error("Unable to subscribe",e);

				// Return response
				AddListResponse response = new AddListResponse();
				response.setCode("FAILURE");
				response.setDescription("Unable to subscribe");
				
				return response;
			}

		} catch (Exception e) {
			logger.error("Problem with subscription request");

			// Return response
			AddListResponse response = new AddListResponse();
			response.setCode("FAILURE");
			response.setDescription("Problem with subscription request");
			
			return response;
		}
		logger.debug("Success in subscribing");
		
		AddListResponse response = new AddListResponse();
		response.setCode("SUCCESS");
		response.setDescription("User has been subscribed");

		// Return response
		return response;
	}
}
