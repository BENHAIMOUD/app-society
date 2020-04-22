package org.society.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.exceptions.ResourceNotFoundException;
import org.society.models.Citizen;
import org.society.services.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@ApiOperation(value="Fetches all citizens in the database", response=Citizen.class)
@RestController
@RequestMapping("citizens")
public class CitizenController {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(CitizenController.class);

    final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    /**
     * find All Citizens
     * @return Citizen
     * @throws Exception
     */
    //@ApiOperation(value = "", response = List.class)
    @GetMapping(value = {""},produces = "application/json" )
    public ResponseEntity<List<Citizen>> getCitizens(){
        List<Citizen> results=citizenService.getCitizens()
                .orElseThrow(()->new ResourceNotFoundException("No Citizen found..!"));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * find citizen by his id
     * @param id
     * @return Citizen
     * @throws Exception
     */

    //@ApiOperation(value = "", response = Citizen.class)
    @GetMapping(value= "/{id}", produces ="application/json")
    public ResponseEntity<Citizen> findCitizen(@PathVariable("id") Long id){
        // logger.debug("display citizen his id:"+id);
        Citizen result =citizenService.getCitizenById(id)
                .orElseThrow(()-> {
                            return new ResourceNotFoundException("No Citizen with id :"+ id);
                        }
                );
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    /**
     * find citizen by his CNI
     * @param CNI
     * @return
     * @throws Exception
     */

    //@ApiOperation(value = "", response = Citizen.class)
    @GetMapping(value = "/{CNI}", produces ="application/json")
    public ResponseEntity<Citizen> finCitizenByCNI(@PathVariable("CNI") String CNI){
        // logger.debug("display citizen his CNI:"+CNI);
        Citizen result =citizenService.getCitizenByCNI(CNI)
                .orElseThrow(()-> {
                            return new ResourceNotFoundException("No Citizen with CNI :"+ CNI);
                        }
                );
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    /**
     * create {@link Citizen}
     * @param citizen
     * @return
     * @throws Exception
     */
    //@ApiOperation(value = " ", response = Citizen.class, code = 200)
    @PostMapping(value ="", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Citizen> createCitizen(@Valid @RequestBody Citizen citizen){
        Citizen result = citizenService.saveCitizen(citizen)
                .orElseThrow(()->{
                    return new ResourceNotFoundException("could not create:"+ citizen.toString());
                });
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    /**
     * update {@link Citizen}
     * @param citizen
     * @return <Citizen>
     * @throws Exception
     */

    //@ApiOperation(value = " ", response = Citizen.class)
    @PutMapping(value ="", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Citizen> updateCitizen(@RequestBody Citizen citizen)  {
        Citizen result = citizenService.update(citizen)
                .orElseThrow(()->{
                    return new ResourceNotFoundException("could not update:"+ citizen.toString());
                });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //@ApiOperation(value = "Supprimer ")
    @DeleteMapping(value ="/{id}", produces = "application/json")
    public ResponseEntity<Map<String, Object>> deleteCitizen(@PathVariable Long id) {
        citizenService.delete(id);
        Map<String, Object> msg = new HashMap<>();
        msg.put("citizen Id", id);
        msg.put("message", "citizen successfully deleted");
        return new ResponseEntity<Map<String, Object>>(msg , HttpStatus.OK);
    }
    //@ApiOperation(value = "Supprimer ")
    @DeleteMapping(value ="", produces = "application/json")
    public ResponseEntity<Map<String, Object>> deleteCitizens() {
        citizenService.deleteAll();
        Map<String, Object> msg = new HashMap<>();
        msg.put("message", "citizens successfully deleted");
        return new ResponseEntity<Map<String, Object>>(msg , HttpStatus.OK);
    }


}
