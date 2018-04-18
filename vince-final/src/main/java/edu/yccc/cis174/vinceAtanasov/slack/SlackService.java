package edu.yccc.cis174.vinceAtanasov.slack;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

/**
 * First pass integration with slack.
 * 
 * 
 * @author Vince
 *
 */


public class SlackService {
	// #integration webhook url. Create your own channel and add the webhook app.
	// Then update this with your value.
	private String webHookUrl = "https://hooks.slack.com/services/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";
	private SlackApi api = new SlackApi(webHookUrl);

	public void sendMessage(String channel, String userName, String message) {
		api.call(new SlackMessage(channel, userName, message));
	}

}
