package pja.tpo.ecommerceshop.Controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pja.tpo.ecommerceshop.Model.Client;
import pja.tpo.ecommerceshop.Model.DTOs.ClientCreateDTO;
import pja.tpo.ecommerceshop.Service.ClientService;

@Controller
@RequestMapping("/register")
public class RegisterationController {

    private final ClientService clientService;

    public RegisterationController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("clientCreateDTO", new ClientCreateDTO());
        return "register";
    }

    @PostMapping()
    public String registerClient(@Valid @ModelAttribute("clientCreateDTO") ClientCreateDTO clientDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        if (bindingResult.hasErrors()) { //validation errors
            return "register";
        }

        try {
            Client savedClient = clientService.createClient(clientDTO);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Rejestracja zakończona pomyślnie! Konto zostało utworzone.");

            return "redirect:/register?success";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Wystąpił błąd podczas rejestracji: " + e.getMessage());
            return "register";
        }
    }
}
