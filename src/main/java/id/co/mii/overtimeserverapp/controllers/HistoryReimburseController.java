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
@PreAuthorize("hasRole('HR')")
public class HistoryReimburseController {
    
    private HistoryReimburseService historyReimburseService;

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "READ_HR" yang dapat mengakses endpoint "/getAll"
    @PreAuthorize("hasAuthority('READ_HR')")
    @GetMapping
    public List<HistoryReimburse> getAll() {
        return historyReimburseService.getAll();
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "READ_HR" yang dapat mengakses endpoint "/getById/{id}"
    @PreAuthorize("hasAuthority('READ_HR')")
    @GetMapping("/{id}")
    public HistoryReimburse getById(@PathVariable Integer id) {
        return historyReimburseService.getById(id);
    }

    // @PostMapping
    // public HistoryReimburse create(@RequestBody HistoryReimburse historyReimburse) {
    //     return historyReimburseService.create(historyReimburse);
    // }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "CREATE_HR" yang dapat mengakses endpoint "/create"
    @PreAuthorize("hasAuthority('CREATE_HR')")
    @PostMapping
    public HistoryReimburse create(@RequestBody HistoryReimburse historyReimburse) {
        return historyReimburseService.create(historyReimburse);
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "UPDATE_HR" yang dapat mengakses endpoint "/update/{id}"
    @PreAuthorize("hasAuthority('UPDATE_HR')")
    @PutMapping("/{id}")
    public HistoryReimburse update(
            @PathVariable Integer id,
            @RequestBody HistoryReimburse historyReimburse) {
        return historyReimburseService.update(id, historyReimburse);
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "DELETE_HR" yang dapat mengakses endpoint "/delete/{id}"
    @PreAuthorize("hasAuthority('DELETE_HR')")
    @DeleteMapping("/{id}")
    public HistoryReimburse delete(@PathVariable Integer id) {
        return historyReimburseService.delete(id);
    }
}
