package com.mse.mzad.app.internal.api;

import com.mse.mzad.app.internal.application.commands.page.CreatePage;
import com.mse.mzad.app.internal.application.commands.page.DeletePage;
import com.mse.mzad.app.internal.application.commands.page.UpdatePage;
import com.mse.mzad.app.internal.application.queries.page.ReadPage;
import com.mse.mzad.app.internal.domain.dtos.page.CreateRequest;
import com.mse.mzad.app.internal.domain.dtos.page.UpdateRequest;
import com.mse.mzad.app.internal.domain.models.Page;
import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/page")
public class PageController {
    @Autowired
    private CreatePage createPage;
    @Autowired
    private UpdatePage updatePage;
    @Autowired
    private DeletePage deletePage;
    @Autowired
    private ReadPage readPage;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String, Page>> create(@RequestBody CreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Page Created Successfully", createPage.create(request)));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<String, Page>> update(@RequestBody UpdateRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Page Updated Successfully", updatePage.update(request)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse<String, Void>> delete(@PathVariable long id) {
        deletePage.delete(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Page Deleted Successfully", null));
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<String, List<Page>>> all() {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "These All Pages", readPage.all()));
    }
}
