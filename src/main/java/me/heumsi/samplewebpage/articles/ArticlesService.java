package me.heumsi.samplewebpage.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {

    @Autowired
    ArticlesRepository articlesRepository;

    public List<Article> getAllArticles() {
        return articlesRepository.findAll();
    }

    public List<Article> getArticles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return articlesRepository.findByIdGreaterThanOrderByIdDesc(0l, pageable);
    }

    public Article insertArticle(Article article) {
        return articlesRepository.save(article);
    }
}
