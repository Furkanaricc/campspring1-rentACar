package kodlama.io.rentACar.webApiController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;

import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController//anotation
@RequestMapping("/api/brands")

public class BrandsController {
    private BrandService brandService;
    private HttpStatus code;


    @Autowired
    public BrandsController(BrandService brandService){
        this.brandService=brandService;

    }
    @GetMapping()
    public List<GetAllBrandResponse> getAll(){

        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){

        return brandService.getById(id);

    }
    @PostMapping()
@ResponseStatus(code=HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/id")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }


}
