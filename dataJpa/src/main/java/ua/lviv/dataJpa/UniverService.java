package ua.lviv.dataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UniverService {

    private UniverDAO univerDAO;

    @Autowired
    public UniverService(UniverDAO univerDAO) {
        this.univerDAO = univerDAO;
    }

    public Univer insert(Univer univer){
        return univerDAO.saveAndFlush(univer);
    }

    public List<Univer> findByName(String name){
        return univerDAO.findByName(name);
    }

    public Univer findById(int id){
        return univerDAO.findById(id);
    }

    @Transactional
    public void update(int id, String name, int levelOfAccreditation, int countOfInstitutes, int countOfStudents, String address){
        univerDAO.update(name, levelOfAccreditation, countOfInstitutes, countOfStudents, address, id);
    }

    @Transactional
    public void delete(int id){
        univerDAO.delete(id);
    }

}
