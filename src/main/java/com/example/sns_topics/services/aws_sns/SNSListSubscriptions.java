package com.example.sns_topics.services.aws_sns;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.ListSubscriptionsRequest;
import software.amazon.awssdk.services.sns.model.ListSubscriptionsResponse;
import software.amazon.awssdk.services.sns.model.SnsException;
import software.amazon.awssdk.services.sns.model.Subscription;

public class SNSListSubscriptions {
  public static String getTopicArn(SnsClient snsClient, String emailToUnsub) {

    try {
      ListSubscriptionsRequest request = ListSubscriptionsRequest.builder()
          .build();

      ListSubscriptionsResponse result = snsClient.listSubscriptions(request);
      String subArn = "u";

      for (int i = 0; i < result.subscriptions().size(); i++) {
        Subscription sub = result.subscriptions().get(i);
        if (sub.endpoint().equals(emailToUnsub)) {
          subArn = sub.subscriptionArn();
        }

      }
      return subArn;

    } catch (SnsException e) {

      System.err.println(e.awsErrorDetails().errorMessage());
      System.exit(1);
    }
    return null;

  }
}
