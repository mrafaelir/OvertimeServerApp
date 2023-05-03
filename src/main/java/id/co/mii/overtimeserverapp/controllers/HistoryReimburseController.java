package id.co.mii.overtimeserverapp.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.overtimeserverapp.models.HistoryReimburse;
import id.co.mii.overtimeserverapp.services.HistoryReimburseService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/historyreimburse")
@PreAuthorize("hasRole('ADMIN')")
public class HistoryReimburseController {
    
    private HistoryReimburseService historyReimburseService;

    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping
    public List<HistoryReimburse> getAll() {
        return historyReimburseService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping("/{id}")
    public HistoryReimburse getById(@PathVariable Integer id) {
        return historyReimburseService.getById(id);
    }

    @PostMapping("hasAuthority('CREATE_ADMIN')")
    public HistoryReimburse create(@RequestBody HistoryReimburse historyReimburse) {
        return historyReimburseService.create(historyReimburse);
    }

    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public HistoryReimburse update(
            @PathVariable Integer id,
            @RequestBody HistoryReimburse historyReimburse) {
        return historyReimburseService.update(id, historyReimburse);
    }

    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public HistoryReimburse delete(@PathVariable Integer id) {
        return historyReimburseService.delete(id);
    }
}