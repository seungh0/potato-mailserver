# 감자서버 메시지 큐 서버

## 기능
- 회원가입시 이메일 검증 메일 발송

## 기술
- AWS SQS
- Java Mail

## 프로퍼티
### application-aws.yml

```yaml
---
spring:
  profiles: dev
cloud:
  aws:
    sqs:
      queue:
        url: <Queue-url>
    region:
      static: <Queue-region>
    credentials:
      accessKey: <AWS-accesskey>
      secretKey: <AWS-secretkey>
      instance-profile: true
    stack:
      auto: false
```

### application-email.yml

```yaml
---
spring:
  profiles: dev
mail:
  google:
    sender: <send-email>
    password: <send-email-password>

```