package com.mse.mzad.app.internal.api;

import com.mse.mzad.app.internal.application.commands.setting.CreateSetting;
import com.mse.mzad.app.internal.application.commands.setting.DeleteSetting;
import com.mse.mzad.app.internal.application.commands.setting.UpdateSetting;
import com.mse.mzad.app.internal.application.queries.setting.ReadSetting;
import com.mse.mzad.app.internal.domain.dtos.setting.CreateRequest;
import com.mse.mzad.app.internal.domain.dtos.setting.UpdateRequest;
import com.mse.mzad.app.internal.domain.models.setting.Setting;
import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/setting")
public class SettingController {
    @Autowired
    private CreateSetting createSetting;
    @Autowired
    private UpdateSetting updateSetting;
    @Autowired
    private DeleteSetting deleteSetting;
    @Autowired
    private ReadSetting readSetting;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String, Setting>> create(@RequestBody CreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Setting Created Successfully", createSetting.create(request)));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<String, Setting>> update(@RequestBody UpdateRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Setting Updated Successfully", updateSetting.update(request)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse<String, Void>> delete(@PathVariable long id) {
        deleteSetting.delete(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Setting Deleted Successfully", null));
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<String, List<Setting>>> all() {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "These All Settings", readSetting.all()));
    }
}
