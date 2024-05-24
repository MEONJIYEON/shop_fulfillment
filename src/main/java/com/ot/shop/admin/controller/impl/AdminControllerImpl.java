package com.ot.shop.admin.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.shop.admin.controller.AdminController;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.dto.MainToShopDTO;
import com.ot.shop.admin.data.dto.NonMemberOrderRequestDTO;
import com.ot.shop.admin.data.dto.ShopToMainDTO;
import com.ot.shop.admin.data.dto.ShopToMainResponseDTO;
import com.ot.shop.admin.service.AdminService;
import com.ot.shop.product.data.dto.ProductResponseDTO;
import com.ot.shop.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/shop-fulfillment")
public class AdminControllerImpl implements AdminController {

	private final AdminService adminService;
	private final ProductService productService;

	@Autowired
	public AdminControllerImpl(AdminService adminService, ProductService productService) {
		this.adminService = adminService;
		this.productService = productService;
	}

//	@GetMapping("/getAllOrders()")
//	public ResponseEntity<List<NonMemberInfoCreateRequestDTO>> getAllOrders() {
//		List<NonMemberInfoCreateRequestDTO> orders = adminService.findAllOrder();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(orders);
//	}

	@GetMapping("/selectAllOrder")
	public ModelAndView selectAllOrder() {
		List<NonMemberOrderRequestDTO> orders = adminService.findAllOrder();
		System.out.println("------------------ orders : =>" + orders);
		ModelAndView mav = new ModelAndView("selectAllOrder");
		mav.addObject("orders", orders);

		return mav;

	}

	@GetMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@PostMapping("/loginCheck")
	public ModelAndView loginCheck(@RequestParam(value = "id", required = false, defaultValue = "") String id) {
		ModelAndView mav = new ModelAndView();

		AdminLoginRequestDTO loginResult = adminService.login(id);

		if (loginResult.getId() != null) {
			List<NonMemberOrderRequestDTO> orders = adminService.findAllOrder();
			List<ProductResponseDTO> products = productService.findAllProduct();
			// login success
			System.out.println(" success loginResult : " + loginResult);
			mav.addObject("loginResult", loginResult);
			mav.addObject("orders", orders);
			mav.addObject("products", products);
			mav.setViewName("index");
		} else {
			// login fail
			System.out.println("fail loginResult : " + loginResult);
			mav.setViewName("fail");
		}

		return mav;
	}

	@GetMapping("/createProduct")
	public ModelAndView createProduct() {
		ModelAndView mav = new ModelAndView("createProduct");
		return mav;
	}

//	@GetMapping("/getAllProducts")
//	public ModelAndView getAllProducts() {
//	    List<ProductResponseDTO> products = productService.findAllProduct();
//	    
//	    ModelAndView mav = new ModelAndView();
//	    mav.addObject("products", products);
//	    mav.setViewName("selectAllProduct"); // 렌더링할 뷰의 이름
//	    
//	    return mav;
//	}

	@GetMapping("/selectAllProduct")
	public ModelAndView selectAllProduct() {
		List<ProductResponseDTO> products = productService.findAllProduct();

		ModelAndView mav = new ModelAndView("selectAllProduct");
		mav.addObject("products", products);
		return mav;
	}
	
	@GetMapping("/updateProduct")
	public ModelAndView updateProduct() {
		List<ProductResponseDTO> products = productService.findAllProduct();

		
		System.out.println(products.get(0));
		ModelAndView mav = new ModelAndView("updateProduct");
		mav.addObject("products", products);
		return mav;
	}
	

	@GetMapping("/index")
	public ModelAndView index() {
		List<NonMemberOrderRequestDTO> orders = adminService.findAllOrder();
		List<ProductResponseDTO> products = productService.findAllProduct();


		ModelAndView mav = new ModelAndView("index");
		mav.addObject("orders", orders);
		mav.addObject("products", products);
		return mav;
	}
	
	// WebClient 통신 쇼핑 -> 메인 (요청)  
	@PostMapping("/shopToMain")
	public ModelAndView shopToMain(@ModelAttribute ShopToMainDTO shopToMainDTO){
		System.out.println("==============================================");
		System.out.println(shopToMainDTO);
		System.out.println("==============================================");
		adminService.shopToMain(shopToMainDTO);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/api/v1/shop-fulfillment/selectAllOrder");
		return modelAndView; 
	}


	// WebClient 통신 쇼핑 -> 메인 (응답)
	@PostMapping("/mainToShop")
	public ResponseEntity<MainToShopDTO> mainToShop(@RequestBody MainToShopDTO mainToShopDTO){
		System.out.println(mainToShopDTO);
		return ResponseEntity.status(HttpStatus.OK).body(mainToShopDTO);
	}


}
