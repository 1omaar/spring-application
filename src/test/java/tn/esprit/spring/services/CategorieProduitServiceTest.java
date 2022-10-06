package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.exceptions.InvalidEntityException;
import tn.esprit.spring.exceptions.InvalidRequiredException;
import tn.esprit.spring.interfaces.ICategorieProduit;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategorieProduitServiceTest {
    @Autowired
 private ICategorieProduit service;
    @Test
    public void shouldSaveCategorieProduitWithSuccess () throws Exception {
       CategorieProduit exceptedCategorie= CategorieProduit.builder().libelleCategorieProduit("gjshdsj").codeProduit("hjdqsj").build();
       CategorieProduit savedCategorie= service.addCategorieProduit(exceptedCategorie);
        Assertions.assertNotNull(savedCategorie);
        Assertions.assertNotNull(savedCategorie.getIdCategorieProduit());
        Assertions.assertEquals(exceptedCategorie.getCodeProduit(),savedCategorie.getCodeProduit());
        Assertions.assertEquals(exceptedCategorie.getIdCategorieProduit(),savedCategorie.getIdCategorieProduit());
        Assertions.assertEquals(exceptedCategorie.getLibelleCategorieProduit(),savedCategorie.getLibelleCategorieProduit());

    }
    @Test
     public void shouldInvalidEntityExceptionReturn () throws Exception {
        CategorieProduit exceptedCategorie= null;
        InvalidEntityException exceptedException = assertThrows(InvalidEntityException.class,()->service.addCategorieProduit(exceptedCategorie));
        assertEquals("entity empty!!",exceptedException.getMessage());
    }
    @Test
    public void shouldThrowInvalidRequiredException (){
        CategorieProduit exceptedCategorie = CategorieProduit.builder().libelleCategorieProduit("sdqdq").build();
        InvalidRequiredException exceptedException = assertThrows(InvalidRequiredException.class,()->service.addCategorieProduit(exceptedCategorie));
        assertEquals(exceptedException.getClass(),InvalidRequiredException.class);
    }

}