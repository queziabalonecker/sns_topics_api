package com.example.sns_topics.services.aws_sns;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

public class SNSClient {
  
	public static SnsClient returnSNSClient(AwsCredentialsProvider credentialsProvider) {
        SnsClient snsClient = SnsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .build();
        return snsClient;
    };
}