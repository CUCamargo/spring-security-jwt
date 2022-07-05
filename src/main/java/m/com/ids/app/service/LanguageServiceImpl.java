package m.com.ids.app.service;

import m.com.ids.app.exception.ResourceNotFoundException;
import m.com.ids.app.model.Language;
import m.com.ids.app.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language updateLanguage(Language language) {
        Optional<Language> productDb = this.languageRepository.findById(language.getId());

        if (productDb.isPresent()) {
            Language languageUpdate = productDb.get();
            languageUpdate.setId(language.getId());
            languageUpdate.setCode(language.getCode());
            languageUpdate.setName(language.getName());
            languageRepository.save(languageUpdate);
            return languageUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + language.getId());
        }
    }

    @Override
    public List<Language> getAllLanguage() {
        return this.languageRepository.findAll();
    }

    @Override
    public Language getById(long productId) {

        Optional<Language> productDb = this.languageRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteLanguage(long productId) {
        Optional<Language> productDb = this.languageRepository.findById(productId);

        if (productDb.isPresent()) {
            this.languageRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }
}
