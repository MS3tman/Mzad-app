package com.mse.mzad.app.internal.domain.contracts;

import com.mse.mzad.app.internal.domain.models.setting.Setting;
import java.util.List;

public interface ISettingRepo {
    Setting save(Setting setting);
    Setting findById(long id);
    Setting update(Setting setting);
    void delete(Setting setting);
    List<Setting> findAll();
}
