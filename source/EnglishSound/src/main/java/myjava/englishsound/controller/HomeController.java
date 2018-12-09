/**
 * 
 */
package myjava.englishsound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Hp
 *
 *
 *
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
}
