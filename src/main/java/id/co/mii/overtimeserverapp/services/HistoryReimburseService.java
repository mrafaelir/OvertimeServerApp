package id.co.mii.overtimeserverapp.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.overtimeserverapp.models.HistoryReimburse;
import id.co.mii.overtimeserverapp.repositories.HistoryReimburseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HistoryReimburseService {
    
    private HistoryReimburseRepository historyReimburseRepository;

    //method untuk menampilkan semua data History Reimburse
    public List<HistoryReimburse> getAll() {
        return historyReimburseRepository.findAll();
    }

    //method untuk menampilkan data History Reimburse berdasarkan id
    public HistoryReimburse getById(Integer id) {
        return historyReimburseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "HistoryReimburse not found!!"));
    }

    // public HistoryReimburse create(HistoryReimburse historyReimburse) {
    //     return historyReimburseRepository.save(historyReimburse);
    // }

    //method untuk (create) menambahkan data History Reimburse
    public HistoryReimburse create(HistoryReimburse historyReimburse) {
        return historyReimburseRepository.save(historyReimburse);
    }

    //method untuk (update) mengubah data History Reimburese
    public HistoryReimburse update(Integer id, HistoryReimburse historyReimburse) {
        getById(id); // method getById
        historyReimburse.setId(id);
        return historyReimburseRepository.save(historyReimburse);
    }

    //method untuk (delete) menghapus data History Reimburse
    public HistoryReimburse delete(Integer id) {
        HistoryReimburse employee = getById(id);
        historyReimburseRepository.delete(employee);
        return employee;
    }
}
