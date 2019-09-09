package burak.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SpringSecurityController {

    @GetMapping("")
    public String notSecured() {
        return "This information is not Secured and visible to all";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/secured")
    public String secured() {

        return "Secured Information";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String adminInformation() {
        return "Information for only Admins";
    }

}
