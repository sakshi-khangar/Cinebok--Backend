package com.cinebokk.controller;



import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.DTO.PaymentRequest;

import com.razorpay.Order;

import com.razorpay.RazorpayClient;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")

public class PaymentController {

	@Value("${razorpay.key}")
	private String key;

	@Value("${razorpay.secret}")
	private String secret;

	@PostMapping("/create")

	public Map<String, Object> createOrder(

			@RequestBody PaymentRequest request

	) throws Exception {

		RazorpayClient client =

				new RazorpayClient(

						key,

						secret

				);

		JSONObject options =

				new JSONObject();

		options.put(

				"amount",

				request.getAmount() * 100

		);

		options.put(

				"currency",

				"INR"

		);

		options.put(

				"receipt",

				"receipt_"

						+

						System.currentTimeMillis()

		);

		Order order =

				client.orders.create(

						options

				);

		Map<String, Object> response =

				new HashMap<>();

		response.put(

				"id",

				order.get("id")

		);

		response.put(

				"amount",

				order.get("amount")

		);

		response.put(

				"currency",

				order.get("currency")

		);

		response.put(

				"key",

				key

		);

		return response;

	}
	
	
	@PostMapping("/event/create")

	public Map<String,Object> eventPayment(

	@RequestBody
	PaymentRequest request

	)throws Exception{

	return createOrder(
	request
	);

	}

}