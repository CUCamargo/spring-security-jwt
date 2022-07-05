package m.com.ids.app.service;

import m.com.ids.app.model.Language;
import java.util.List;

public interface LanguageService {
    Language createLanguage(Language language);
    Language updateLanguage(Language language);
    List<Language> getAllLanguage();

    Language getById(long languageId);

    void deleteLanguage(long id);
}
