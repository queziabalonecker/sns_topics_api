package com.example.sns_topics.services.aws_sns;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class CredentialsProvider {
    public static AwsCredentialsProvider returnCredentials() {
        AwsCredentialsProvider credentialsProvider = new AwsCredentialsProvider() {
            @Override
            public AwsCredentials resolveCredentials() {
                return new AwsCredentials() {
                    @Override
                    public String accessKeyId() {
                        return System.getenv("ACCESS_KEY_ID");
                    }

                    @Override
                    public String secretAccessKey() {
                        return System.getenv("SECRET_ACCESS_KEY");
                    }
                };
            };
        };
        return credentialsProvider;
    };
}
