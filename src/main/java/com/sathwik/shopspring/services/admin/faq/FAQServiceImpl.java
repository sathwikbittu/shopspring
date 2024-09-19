package com.sathwik.shopspring.services.admin.faq;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sathwik.shopspring.dto.FAQDto;
import com.sathwik.shopspring.model.FAQ;
import com.sathwik.shopspring.model.Product;
import com.sathwik.shopspring.repository.FAQRepository;
import com.sathwik.shopspring.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FAQServiceImpl implements FAQService {
	private final FAQRepository faqRepository;

	private final ProductRepository productRepository;

	public FAQDto postFAQ(Long productId, FAQDto faqDto) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()) {
			FAQ faq = new FAQ();
			faq.setQuestion(faqDto.getQuestion());
			faq.setAnswer(faqDto.getAnswer());
			faq.setProduct(optionalProduct.get());

			FAQ savedFAQ = faqRepository.save(faq);
			log.info("FAQ posted successfully for product with ID: {}", productId);
			return savedFAQ.getFAQDto();
		}

		log.warn("Failed to post FAQ. Product with ID {} not found.", productId);
		return null;
	}

}
