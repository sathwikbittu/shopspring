package com.sathwik.shopspring.services.admin.faq;

import com.sathwik.shopspring.dto.FAQDto;

public interface FAQService {
	FAQDto postFAQ(Long productId, FAQDto faqDto);
}
