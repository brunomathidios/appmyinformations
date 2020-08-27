package ca.bm.mes.informations.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eu.bitwalker.useragentutils.UserAgent;

@Controller
public class HomeController {
	
	@GetMapping
	public String home(HttpServletRequest request, Model model) {
		
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		model.addAttribute("navegador", userAgent.getBrowser().getName());
		model.addAttribute("versao", userAgent.getBrowserVersion().getVersion());
		
		model.addAttribute("ip", request.getHeader("Host"));//X-Forwarded-For
		
		model.addAttribute("os", userAgent.getOperatingSystem().getName());
		model.addAttribute("dispositivo", userAgent.getOperatingSystem().getDeviceType().getName());
		model.addAttribute("marca", userAgent.getOperatingSystem().getManufacturer().getName());
		model.addAttribute("grupo", userAgent.getOperatingSystem().getGroup().getName());
		
		
		return "home";
	}
	
}
