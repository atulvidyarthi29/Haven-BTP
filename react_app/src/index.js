import React from 'react';
import ReactDOM from 'react-dom';
import { Router ,Switch, Link, Route} from "react-router-dom";
import { createBrowserHistory } from "history";

import App from './App';
import * as serviceWorker from './serviceWorker';
import Login from '../src/components/login_comp';

//import './App.css';
import './assets/scss/style.scss';
import SignUp from './components/signup_comp';
import Blog from './components/blog_comp';
import Blog_Details from './components/sections/blog_details';
import PostForm from './components/sections/post_form';
import Authority from './components/sections/authority_list';
import Journalist from './components/sections/journalist_list';


const history = createBrowserHistory();

ReactDOM.render(
  <Router history={history}>
    <App />
    <Switch>
    <Route path="/sign-in" component={Login} />
    <Route path="/sign-up" component={SignUp} />
    <Route path="/blog" component={Blog} />
    <Route path="/blog-details" component={Blog_Details} />
    <Route path="/blog-post" component={PostForm} />
    <Route path="/authorities" component={Authority} />
    <Route path="/journalists" component={Journalist} />
    </Switch>
  </Router>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
