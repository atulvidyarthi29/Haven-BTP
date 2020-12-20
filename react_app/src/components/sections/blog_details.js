import React, { Component } from "react";
import Image from '../elements/Image';
import classNames from 'classnames';
import AuthService from "../../services/auth-service";
import axios from 'axios';

const POST = ""

export default class Blog_Details extends Component {
    constructor(props) {
        super(props);
        this.state = {
            post: ""
        };
    }

    componentDidMount() {
        const jwt = AuthService.getCurrentJWT();

        axios.get(POST, {
            headers: {
                "Authorization": "Bearer " + jwt
            }
        })
            .then(response => response.data)
            .then((data) => {
                console.log(data);
                this.setState({
                    post: data
                });
            }
            );
    }

    render() {
        return (
            <div id="wrapper">


                <section className="section single-wrapper">
                    <div className="image_section2">
                        <Image
                            src={require('./../../assets/images/blog_single.jpg')}
                            alt="Features tile icon 01"
                            width="100%"
                            height="60%"
                        />


                    </div>

                    <div className="container_blog2">
                        <center>
                            <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="900">
                                BLOG<span className="text-color-primary">DETAILS</span>
                            </h1>       </center>
                    </div>
                    <div className="heit">
                    </div>
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                                <div className="page-wrapper">
                                    <div className="blog-title-area text-center">




                                        <h3>Injustice to me </h3>

                                        <div className="blog-meta big-meta">
                                            <small><a href="tech-single.html" title="">21 July, 2017</a></small>
                                            <small><a href="tech-author.html" title="">by Jessica</a></small>
                                            <small><a href="#" title=""><i className="fa fa-eye"></i> 2344</a></small>
                                        </div>


                                    </div>

                                    <div className="single-post-media">
                                        <img src="upload/tech_menu_08.jpg" alt="" className="img-fluid" />
                                    </div>
                                    <div className="single-post-media">
                                        <img src="upload/tech_menu_08.jpg" alt="" className="img-fluid" />
                                    </div>
                                    <div className="single-post-media">
                                        <img src="upload/tech_menu_08.jpg" alt="" className="img-fluid" />
                                    </div>

                                    <div className="blog-content">
                                        <div className="pp">
                                            <p>The court has sentenced me to death.</p>

                                        </div>

                                    </div>

                                    <div className="blog-title-area">
                                        <div className="tag-cloud-single">
                                            <span>Actions</span>
                                            <small><a href="#" title="">Upvotes</a></small>
                                            <small><a href="#" title=""> 58 </a></small>
                                            <small><a href="#" title="">Downvote</a></small>
                                            <small><a href="#" title=""> 58 </a></small>

                                        </div>

                                        <div className="post-sharing">
                                            <ul className="list-inline">
                                                <li><a href="#" className="fb-button btn btn-primary"> <span className="down-mobile">Upvote</span></a></li>
                                                <li><a href="#" className="tw-button btn btn-primary"> <span className="down-mobile">Downvote</span></a></li>

                                            </ul>
                                        </div>
                                    </div>



                                    <hr className="invis1" />

                                    <div className="custombox prevnextpost clearfix">
                                        <div className="row">
                                            <div className="col-lg-6">
                                                <div className="blog-list-widget">
                                                    <div className="list-group">
                                                        <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                            <div className="w-100 justify-content-between text-right">
                                                                <img src="upload/tech_menu_19.jpg" alt="" className="img-fluid float-right" />
                                                                <h5 className="mb-1">5 Beautiful buildings you need to before dying</h5>
                                                                <small>Prev Post</small>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>

                                            <div className="col-lg-6">
                                                <div className="blog-list-widget">
                                                    <div className="list-group">
                                                        <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                            <div className="w-100 justify-content-between">
                                                                <img src="upload/tech_menu_20.jpg" alt="" className="img-fluid float-left" />
                                                                <h5 className="mb-1">Let's make an introduction to the glorious world of history</h5>
                                                                <small>Next Post</small>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <hr className="invis1" />

                                    <div className="custombox authorbox clearfix">
                                        <h4 className="small-title">About author</h4>
                                        <div className="row">
                                            <div className="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                                                <img src="upload/author.jpg" alt="" className="img-fluid rounded-circle" />
                                            </div>

                                            <div className="col-lg-10 col-md-10 col-sm-10 col-xs-12">
                                                <h4><a href="#">journalist</a></h4>
                                                <p>I'm from Republic Bharat.</p>



                                            </div>
                                        </div>
                                    </div>

                                    <hr className="invis1" />



                                    <hr className="invis1" />

                                    <div className="custombox clearfix">
                                        <h4 className="small-title">3 Comments</h4>
                                        <div className="row">
                                            <div className="col-lg-12">
                                                <div className="comments-list">
                                                    <div className="media">
                                                        <a className="media-left" href="#">
                                                            <img src="upload/author.jpg" alt="" className="rounded-circle" />
                                                        </a>
                                                        <div className="media-body">
                                                            <h4 className="media-heading user_name">user1  <small>today</small></h4>
                                                            <p> You can approach the Supreme Court</p>
                                                            <a href="#" className="btn btn-primary btn-sm">Reply</a>
                                                        </div>
                                                    </div>
                                                    <div className="media">
                                                        <a className="media-left" href="#">
                                                            <img src="upload/author_01.jpg" alt="" className="rounded-circle" />
                                                        </a>
                                                        <div className="media-body">

                                                            <h4 className="media-heading user_name">user222 <small>today</small></h4>

                                                            <p>Accept your fate.</p>

                                                            <a href="#" className="btn btn-primary btn-sm">Reply</a>
                                                        </div>
                                                    </div>
                                                    <div className="media last-child">
                                                        <a className="media-left" href="#">
                                                            <img src="upload/author_02.jpg" alt="" className="rounded-circle" />
                                                        </a>
                                                        <div className="media-body">

                                                            <h4 className="media-heading user_name">suv123 <small>5 days ago</small></h4>
                                                            <p> What are you speaking?</p>

                                                            <a href="#" className="btn btn-primary btn-sm">Reply</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <hr className="invis1" />

                                    <div className="custombox clearfix">
                                        <h4 className="small-title">Leave a Reply</h4>
                                        <div className="row">
                                            <div className="col-lg-12">
                                                <form className="form-wrapper">
                                                    <textarea className="form-control" placeholder="Your comment"></textarea>
                                                    <button type="submit" className="btn btn-primary">Submit Comment</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                <div className="sidebar">


                                    <div className="widget">
                                        <h2 className="widget-title">Trending posts</h2>
                                        <div className="trend-videos">
                                            <div className="blog-box">
                                                <div className="post-media">
                                                    <a href="tech-single.html" title="">
                                                        <img src="upload/tech_video_01.jpg" alt="" className="img-fluid" />
                                                        <div className="hovereffect">
                                                            <span className="videohover"></span>
                                                        </div>
                                                    </a>
                                                </div>
                                                <div className="blog-meta">
                                                    <h4><a href="tech-single.html" title="">1st Post</a></h4>
                                                </div>
                                            </div>

                                            <hr className="invis" />

                                            <div className="blog-box">
                                                <div className="post-media">
                                                    <a href="tech-single.html" title="">
                                                        <img src="upload/tech_video_02.jpg" alt="" className="img-fluid" />
                                                        <div className="hovereffect">
                                                            <span className="videohover"></span>
                                                        </div>
                                                    </a>
                                                </div>
                                                <div className="blog-meta">
                                                    <h4><a href="tech-single.html" title="">We are guests of ABC Design Studio - Vlog</a></h4>
                                                </div>
                                            </div>

                                            <hr className="invis" />

                                            <div className="blog-box">
                                                <div className="post-media">
                                                    <a href="tech-single.html" title="">
                                                        <img src="upload/tech_video_03.jpg" alt="" className="img-fluid" />
                                                        <div className="hovereffect">
                                                            <span className="videohover"></span>
                                                        </div>
                                                    </a>
                                                </div>
                                                <div className="blog-meta">
                                                    <h4><a href="tech-single.html" title="">Both blood pressure monitor and intelligent clock</a></h4>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div className="widget">
                                        <h2 className="widget-title">Popular Posts</h2>
                                        <div className="blog-list-widget">
                                            <div className="list-group">
                                                <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                    <div className="w-100 justify-content-between">
                                                        <img src="upload/tech_blog_08.jpg" alt="" className="img-fluid float-left" />
                                                        <h5 className="mb-1">5 Beautiful buildings you need..</h5>
                                                        <small>12 Jan, 2016</small>
                                                    </div>
                                                </a>

                                                <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                    <div className="w-100 justify-content-between">
                                                        <img src="upload/tech_blog_01.jpg" alt="" className="img-fluid float-left" />
                                                        <h5 className="mb-1">Let's make an introduction for..</h5>
                                                        <small>11 Jan, 2016</small>
                                                    </div>
                                                </a>

                                                <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                    <div className="w-100 last-item justify-content-between">
                                                        <img src="upload/tech_blog_03.jpg" alt="" className="img-fluid float-left" />
                                                        <h5 className="mb-1">Did you see the most beautiful..</h5>
                                                        <small>07 Jan, 2016</small>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>

                                    <div className="widget">
                                        <h2 className="widget-title">Recent Posts</h2>
                                        <div className="blog-list-widget">
                                            <div className="list-group">
                                                <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                    <div className="w-100 justify-content-between">
                                                        <img src="upload/tech_blog_02.jpg" alt="" className="img-fluid float-left" />
                                                        <h5 className="mb-1">Banana-chip chocolate cake recipe..</h5>

                                                    </div>
                                                </a>

                                                <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                    <div className="w-100 justify-content-between">
                                                        <img src="upload/tech_blog_03.jpg" alt="" className="img-fluid float-left" />
                                                        <h5 className="mb-1">10 practical ways to choose organic..</h5>

                                                    </div>
                                                </a>

                                                <a href="tech-single.html" className="list-group-item list-group-item-action flex-column align-items-start">
                                                    <div className="w-100 last-item justify-content-between">
                                                        <img src="upload/tech_blog_07.jpg" alt="" className="img-fluid float-left" />
                                                        <h5 className="mb-1">We are making homemade ravioli..</h5>

                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>



                                    <div className="widget">
                                        <div className="banner-spot clearfix">
                                            <div className="banner-img">
                                                <img src="upload/banner_03.jpg" alt="" className="img-fluid" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>



                <div className="dmtop">Scroll to Top</div>

            </div>

        );
    }


}