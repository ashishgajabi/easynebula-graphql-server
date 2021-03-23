package au.com.easynebula.easynebulagraphqlserver.resolver;

import au.com.easynebula.easynebulagraphqlserver.model.Author;
import au.com.easynebula.easynebulagraphqlserver.model.Book;
import au.com.easynebula.easynebulagraphqlserver.repository.AuthorRepository;
import au.com.easynebula.easynebulagraphqlserver.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MutationResolver implements GraphQLMutationResolver {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public MutationResolver(final AuthorRepository authorRepository, final BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Author newAuthor(final String firstName, final String lastName) {
		final Author author = new Author(firstName, lastName);
		return authorRepository.save(author);
	}

	public Book newBook(final String title,
	                    final String isbn,
	                    final int pageCount,
	                    final Long authorId) {
		Optional<Author> byId = authorRepository.findById(authorId);
		final Author author = byId.orElse(new Author(authorId));
		final Book book = new Book(title, isbn, pageCount, author);
		return bookRepository.save(book);
	}

	public boolean deleteBook(final Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Book updateBookPageCount(final Integer pageCount, final Long id) {
		Optional<Book> byId = bookRepository.findById(id);
		final Book book = byId.orElseThrow();
		book.setPageCount(pageCount);
		return bookRepository.save(book);
	}
}
