package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.domain.contracts.IPageRepo;
import com.mse.mzad.app.internal.domain.models.Page;
import com.mse.mzad.app.internal.infrastructure.database.PageEntity;
import com.mse.mzad.app.internal.infrastructure.mappers.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PageRepository implements IPageRepo {
    @Autowired
    private IPageRepository pageRepository;

    @Override
    public Page save(Page page) {
        PageEntity pageEntity = PageMapper.toEntityForCreate(page);
        return PageMapper.toDomain(pageRepository.save(pageEntity));
    }

    @Override
    public Page findById(long id) {
        Optional<PageEntity> pageEntity = pageRepository.findById(id);
        if(pageEntity.isEmpty()) {
            throw new RuntimeException("Page not found");
        }
        return PageMapper.toDomain(pageEntity.get());
    }

    @Override
    public Page update(Page page) {
        PageEntity pageEntity = PageMapper.toEntityForUpdate(page);
        return PageMapper.toDomain(pageRepository.save(pageEntity));
    }

    @Override
    public void delete(Page page) {
        PageEntity pageEntity = PageMapper.toEntityForUpdate(page);
        pageRepository.delete(pageEntity);
    }

    @Override
    public List<Page> findAll() {
        List<PageEntity> pageEntityList = pageRepository.findAll();
        if (pageEntityList.isEmpty()) {
            throw new RuntimeException("Not Found Pages");
        }
        List<Page> pageList = new ArrayList<>();
        for(PageEntity pageEntity : pageEntityList) {
            pageList.add(PageMapper.toDomain(pageEntity));
        }
        return pageList;
    }
}
