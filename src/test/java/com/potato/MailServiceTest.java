package com.potato;

import com.potato.external.mail.MailCreator;
import com.potato.external.mail.MailSender;
import com.potato.service.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.activation.DataHandler;
import javax.mail.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;

@SpringBootTest
public class MailServiceTest {

	private MailService mailService;

	@BeforeEach
	void cleanUp() {
		mailService = new MailService(new MockMailCreator(), new MockMailSender());
	}

	@Test
	void 메일이_전송된다() {
		// when
		mailService.sendVerificationEmail("will.seungho@gmail.com");
	}

	private static class MockMailCreator implements MailCreator {

		@Override
		public Message createMessage() throws MessagingException {
			return new Message() {
				@Override
				public Address[] getFrom() throws MessagingException {
					return new Address[0];
				}

				@Override
				public void setFrom() throws MessagingException {

				}

				@Override
				public void setFrom(Address address) throws MessagingException {

				}

				@Override
				public void addFrom(Address[] addresses) throws MessagingException {

				}

				@Override
				public Address[] getRecipients(RecipientType type) throws MessagingException {
					return new Address[0];
				}

				@Override
				public void setRecipients(RecipientType type, Address[] addresses) throws MessagingException {

				}

				@Override
				public void addRecipients(RecipientType type, Address[] addresses) throws MessagingException {

				}

				@Override
				public String getSubject() throws MessagingException {
					return null;
				}

				@Override
				public void setSubject(String subject) throws MessagingException {

				}

				@Override
				public Date getSentDate() throws MessagingException {
					return null;
				}

				@Override
				public void setSentDate(Date date) throws MessagingException {

				}

				@Override
				public Date getReceivedDate() throws MessagingException {
					return null;
				}

				@Override
				public Flags getFlags() throws MessagingException {
					return null;
				}

				@Override
				public void setFlags(Flags flag, boolean set) throws MessagingException {

				}

				@Override
				public Message reply(boolean replyToAll) throws MessagingException {
					return null;
				}

				@Override
				public void saveChanges() throws MessagingException {

				}

				@Override
				public int getSize() throws MessagingException {
					return 0;
				}

				@Override
				public int getLineCount() throws MessagingException {
					return 0;
				}

				@Override
				public String getContentType() throws MessagingException {
					return null;
				}

				@Override
				public boolean isMimeType(String mimeType) throws MessagingException {
					return false;
				}

				@Override
				public String getDisposition() throws MessagingException {
					return null;
				}

				@Override
				public void setDisposition(String disposition) throws MessagingException {

				}

				@Override
				public String getDescription() throws MessagingException {
					return null;
				}

				@Override
				public void setDescription(String description) throws MessagingException {

				}

				@Override
				public String getFileName() throws MessagingException {
					return null;
				}

				@Override
				public void setFileName(String filename) throws MessagingException {

				}

				@Override
				public InputStream getInputStream() throws IOException, MessagingException {
					return null;
				}

				@Override
				public DataHandler getDataHandler() throws MessagingException {
					return null;
				}

				@Override
				public Object getContent() throws IOException, MessagingException {
					return null;
				}

				@Override
				public void setDataHandler(DataHandler dh) throws MessagingException {

				}

				@Override
				public void setContent(Object obj, String type) throws MessagingException {

				}

				@Override
				public void setText(String text) throws MessagingException {

				}

				@Override
				public void setContent(Multipart mp) throws MessagingException {

				}

				@Override
				public void writeTo(OutputStream os) throws IOException, MessagingException {

				}

				@Override
				public String[] getHeader(String header_name) throws MessagingException {
					return new String[0];
				}

				@Override
				public void setHeader(String header_name, String header_value) throws MessagingException {

				}

				@Override
				public void addHeader(String header_name, String header_value) throws MessagingException {

				}

				@Override
				public void removeHeader(String header_name) throws MessagingException {

				}

				@Override
				public Enumeration<Header> getAllHeaders() throws MessagingException {
					return null;
				}

				@Override
				public Enumeration<Header> getMatchingHeaders(String[] header_names) throws MessagingException {
					return null;
				}

				@Override
				public Enumeration<Header> getNonMatchingHeaders(String[] header_names) throws MessagingException {
					return null;
				}
			};
		}
	}

	private static class MockMailSender implements MailSender {

		@Override
		public void sendMail(Message message) throws MessagingException {
		}

	}

}
