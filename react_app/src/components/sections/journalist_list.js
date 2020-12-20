import React, { Component } from "react";
import ButtonGroup from '../elements/ButtonGroup';
import Button from '../elements/Button';
import { Link } from 'react-router-dom';
import './_journalist_list.scss';



function Journalist() {
    return (



        <div >


            <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="200">
                    JOURNALISM<span className="text-color-primary">DEPARTMENT</span>
                </h1>
                <ul className="list-reset header-nav-right">
                    <div className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="400">
                        <li>
                            <Link to="/blog" className="button button-primary button-wide-mobile button-sm" >Go Back</Link>
                        </li>
                    </div>

                </ul></center>


            <ul className="honeycomb" lang="es">
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://images-eu.ssl-images-amazon.com/images/I/61ICYZki04L.png" />
                    <div className="honeycomb-cell__title">Times Now<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkVTWW7vhzRK6Uz1DWkqmM4FclVmf_nPfDLA&usqp=CAU" />
                    <div className="honeycomb-cell__title">NDTV News Network<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://akamaividz2.zee5.com/image/upload/w_1170,h_658,c_scale,f_auto,q_auto/resources/0-9-282/list/indiatv.jpg" />
                    <div className="honeycomb-cell__title">India Today<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://doordarshan.gov.in/sites/default/files/DD-India-logo.png" />
                    <div className="honeycomb-cell__title">DD India<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://akamaividz2.zee5.com/image/upload/w_1170,h_658,c_scale/resources/0-9-aajtak/list/09aajtakaajtak.jpg" />
                    <div className="honeycomb-cell__title">Aaj Tak<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://pbs.twimg.com/profile_images/960865956829392898/E8b911Ol_400x400.jpg" />
                    <div className="honeycomb-cell__title">News 24<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://akamaividz2.zee5.com/image/upload/w_1170,h_658,c_scale,f_auto,q_auto/resources/0-9-162/list/09162republicbharat.jpg" />
                    <div className="honeycomb-cell__title">Republic TV</div>
                </li>
                <li className="honeycomb-cell honeycomb__placeholder"></li>
            </ul>
        </div>



    );
}

export default Journalist;