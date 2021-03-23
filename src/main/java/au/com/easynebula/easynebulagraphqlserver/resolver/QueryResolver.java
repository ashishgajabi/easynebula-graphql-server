package au.com.easynebula.easynebulagraphqlserver.resolver;

import au.com.easynebula.easynebulagraphqlserver.model.Author;
import au.com.easynebula.easynebulagraphqlserver.model.Book;
import au.com.easynebula.easynebulagraphqlserver.repository.AuthorRepository;
import au.com.easynebula.easynebulagraphqlserver.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class QueryResolver implements GraphQLQueryResolver {
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	public QueryResolver(final BookRepository bookRepository, final AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public long countBooks() {
		return bookRepository.count();
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}
