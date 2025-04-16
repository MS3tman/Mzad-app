package com.mse.mzad.app.internal.api;

import com.mse.mzad.app.internal.application.commands.country.CreateCountry;
import com.mse.mzad.app.internal.application.commands.country.DeleteCountry;
import com.mse.mzad.app.internal.application.commands.country.UpdateCountry;
import com.mse.mzad.app.internal.application.queries.country.ReadCountry;
import com.mse.mzad.app.internal.domain.dtos.country.CreateRequest;
import com.mse.mzad.app.internal.domain.dtos.country.UpdateRequest;
import com.mse.mzad.app.internal.domain.models.Country;
import com.mse.mzad.shared.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private CreateCountry createCountry;
    @Autowired
    private UpdateCountry updateCountry;
    @Autowired
    private DeleteCountry deleteCountry;
    @Autowired
    private ReadCountry readCountry;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String, Country>> create(@RequestBody CreateRequest createRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(),"Country Created Successfully",createCountry.create(createRequest)));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<String, Country>> update(@RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Country Updated Successfully", updateCountry.update(updateRequest)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse<String, Void>> delete(@PathVariable long id) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), deleteCountry.delete(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<String, List<Country>>> all() {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "List All Countries", readCountry.list()));
    }
}
