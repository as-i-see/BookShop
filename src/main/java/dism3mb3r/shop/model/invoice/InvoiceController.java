package dism3mb3r.shop.model.invoice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(method = RequestMethod.POST, params = {"selected"})
    public String createInvoice(ModelMap model, HttpServletRequest request) {
        String[] checked = request.getParameterValues("selected");
        model.addAttribute("invoice", invoiceService.createInvoiceForChoices(checked));
        return "invoice";
    }
}
