import React, { Component } from "react";
import ButtonGroup from './elements/ButtonGroup';
import Button from './elements/Button';
import { Link } from 'react-router-dom';
import './_blog_comp.css';
import axios from 'axios';

import AuthService from "../services/auth-service";
import authHeader from "../services/auth-header";
// import PostService from ".../services/post-service.js";

const POST_URL = "http://localhost:8661/forum/posts";
export default class Blog extends Component{

    constructor(props) {
        super(props);
        this.state = {
            posts: [],
        };
    }

    componentDidMount() {
        const jwt = AuthService.getCurrentJWT();
        axios.get(POST_URL, {headers: {
            "Authorization": "Bearer " + jwt
        }})
                .then(response => response.data)
                .then((data) => {
                    console.log(data);
                    if (data.userId)
                        data.userId = this.getUserName(data.userId);
                    else data.userId = "anonymous";
                    this.setState({
                        posts: data
                    });
                }
            );
        console.log(this.state.posts);

    }

    getUserName(id) {
        axios.get("http://localhost:8661/user-details/" + id)
        .then(response => response.data)
        .then((data)=> {
            console.log(data.username);
            return data.username;});
    }

    render() {
        return(
        <div id="wrapper">
            <div className="hei">
                </div>  
                <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="200">
              You deserve justice - <span className="text-color-primary">HAVEN</span>
            </h1>       </center>   
            <div className="container-xs">
              <p className="m-0 mb-32 reveal-from-bottom" data-reveal-delay="400">
              "Fight for the things that you care about, but do it in a way that will lead others to join you."
              
              
                </p>
                <div className="heit">
                </div> 
                <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="900">
              WE<span className="text-color-primary">STAND</span>TOGETHER
            </h1>       </center> 
            <div className="heit">
                </div> 
                <p>
                <div className="reveal-from-top" data-reveal-delay="600">
                    
                <ButtonGroup>
                
                  <Link to="/journalists">
                  <center>
                  <Button tag="a" color="primary"  >
                    
                    Journalists
                    </Button>
                    </center>
                    </Link>
                    
                    <Link to="/authorities">
                  <Button tag="a" color="dark"  >
                    Authorities
                    </Button>
                    </Link>

                    <Link to="/blog-post">
                  <center>
                  <Button tag="a" color="primary"  >
                    
                    Write a post
                    </Button>
                    </center>
                    </Link>
                    
                </ButtonGroup>
               
                
              </div>
                </p>
                
                
            
          </div>
            <div className="container_blog">                   
                    <h10 role="img" aria-label="BLOG"><span className="letter rev">B</span><span className="letter rev">l</span><span className="letter">o</span><span className="letter rev">g</span>
                    </h10>                    
            </div>
    

        

        <section className="section_new">
        
            <div className="container">
                <div className="row">
                    <div className="col-lg-15 col-md-12 col-sm-12 col-xs-12">
                        <div className="page-wrapper">                                                        
                            <hr className="invis1"/>
                            
                            <div className="blog-list clearfix">
                                {
                                    this.state.posts.map((post) => (
                                        
                                            <div className="blog-box row" key={post.id}>
                                                <div className="col-md-4">
                                                    <div className="post-media">
                                                        <a href="\blog-details" title="">
                                                            <img src="../logo192.png" alt="" className="img-fluid"/>
                                                            <div className="hovereffect"></div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div className="blog-meta big-meta col-md-8">
                                                    <h4><a href="\blog-details" title="">{post.title}</a></h4>
                                                    <p>{post.description}</p>
                                                    <small className="firstsmall"><a class="bg-orange" href="tech-category-01.html" title="">Reviews</a></small>
                                                    <small><a href="tech-single.html" title="">17 December, 2020</a></small>
                                                    <small><a href="tech-author.html" title="">by user</a></small>
                                                    <small><a href="tech-single.html" title="" style={{color: "white"}}><i class="fa fa-eye"></i> {post.upVotes}</a></small>
                                                    <small><a href="tech-single.html" title="" style={{color: "white"}}><i class="fa fa-eye"></i> {post.downVotes}</a></small>
                                                </div>
                                            </div>                    
                                    ))
                                }   
                                <hr className="invis"/>
                            </div>
                        </div>
                        <hr className="invis"/>    
                    </div>                    
                </div>
            </div>
        </section>

        
        
    </div>
        );    
}    
}

