import { Suspense, useEffect, useState } from "react";
import { Route, Routes } from "react-router-dom";

import { getAuthors, getBooks, getCategories } from "./api";
import Authors from "../app/components/authors/Authors";
import BookDelete from "../app/components/books/book-delete/BookDelete";
import BookForm from "../app/components/books/book-form/BookForm";
import BookMark from "../app/components/books/book-mark/BookMark";
import Books from "../app/components/books/Books";
import Categories from "../app/components/categories/Categories";
import Header from "../app/components/header/Header";
// import logo from '../../logo.svg';
import './App.css';

export default function App() {
    const [books, setBooks] = useState<Book[]>([]);
    const [categories, setCategories] = useState<string[]>([]);
    const [authors, setAuthors] = useState<Author[]>([]);

    useEffect(() => {
        getBooks().then((books) => setBooks(books));
    }, []);

    useEffect(() => {
        getCategories().then((categories) => setCategories(categories));
    }, []);

    useEffect(() => {
        getAuthors().then((authors) => setAuthors(authors));
    }, []);

    function deleteBook(id: number) {
        setBooks(books.filter((book) => book.id !== id));
    }

    function editBook(book: Book) {
        setBooks(books.map((b) => (b.id === book.id ? book : b)));
    }

    return (
        <>
            <Header />
            <Suspense fallback={<div>Loading...</div>}>
                <div className="container">
                    <Routes>
                        <Route path="/" element={<Books />} />
                        <Route path="/books" element={<Books />} />
                        <Route
                            path="/categories"
                            element={<Categories categories={categories} />}
                        />
                        <Route path="/authors" element={<Authors authors={authors} />} />
                        <Route
                            path="/books/add"
                            element={
                                <BookForm
                                    categories={categories}
                                    authors={authors}
                                    editBookFn={editBook}
                                />
                            }
                        />
                        <Route
                            path="/books/edit/:book"
                            element={
                                <BookForm
                                    categories={categories}
                                    authors={authors}
                                    editBookFn={editBook}
                                />
                            }
                        />
                        <Route
                            path="/books/delete/:book"
                            element={<BookDelete updateState={deleteBook} />}
                        />
                        <Route path="/books/mark/:book" element={<BookMark />} />
                    </Routes>
                </div>
            </Suspense>
        </>
    );
}