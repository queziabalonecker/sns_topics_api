package com.example.sns_topics.controllers;

import com.example.sns_topics.services.aws_sns.CredentialsProvider;
import com.example.sns_topics.services.aws_sns.SNSClient;
import com.example.sns_topics.services.aws_sns.SNSListSubscriptions;
import com.example.sns_topics.services.aws_sns.SNSSubscribeEmail;
import com.example.sns_topics.services.aws_sns.SNSUnsubscribeEmail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.sns.SnsClient;

@RestController
public class SNSController {

  @GetMapping("/subscribe/{emailToSub}")
  public void SubscribeEmail(@PathVariable String emailToSub) {
    SNSSubscribeEmail.subEmail(emailToSub);
  }

  @GetMapping("/unsubscribe/{emailToUnsub}")
  public void UnsubscribeEmail(@PathVariable String emailToUnsub) {
    AwsCredentialsProvider credentialsProvider = CredentialsProvider.returnCredentials();
    SnsClient snsClient = SNSClient.returnSNSClient(credentialsProvider);
    String subscriptionArn = SNSListSubscriptions.getTopicArn(snsClient, emailToUnsub);
    SNSUnsubscribeEmail.unSub(snsClient, subscriptionArn);
  }

}
