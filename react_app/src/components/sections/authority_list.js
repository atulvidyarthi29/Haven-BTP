import React, { Component } from "react";

import { Link } from 'react-router-dom';
import './_journalist_list.scss';



function Authority() {
    return (

        <div >


            <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="200">
                    AUTHORITIES<span className="text-color-primary">HAVEN</span>
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
                    <img className="honeycomb-cell__image" src="https://images.financialexpress.com/2020/09/cyber-security-1200-620x413.jpg" />
                    <div className="honeycomb-cell__title">Cyber Agency<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://upload.wikimedia.org/wikipedia/en/7/78/Defence_Intelligence_Agency_%28India%29_Logo.png" />
                    <div className="honeycomb-cell__title">Defence Agency<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Cbi_logo.svg/1031px-Cbi_logo.svg.png" />
                    <div className="honeycomb-cell__title">Central Bureau<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://upload.wikimedia.org/wikipedia/en/3/31/Central_Bureau_of_Narcotics_Logo.png" />
                    <div className="honeycomb-cell__title">Narcotics Bureau<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://upload.wikimedia.org/wikipedia/en/thumb/e/ed/Enforcement_Directorate.svg/1200px-Enforcement_Directorate.svg.png" />
                    <div className="honeycomb-cell__title">E D<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://upload.wikimedia.org/wikipedia/en/thumb/5/57/Narcotics_Control_Bureau_Seal.svg/1200px-Narcotics_Control_Bureau_Seal.svg.png" />
                    <div className="honeycomb-cell__title">Narcotics Bureau<small>Verified</small></div>
                </li>
                <li className="honeycomb-cell">
                    <img className="honeycomb-cell__image" src="https://mk0timesnextw7n7qiu0.kinstacdn.com/wp-content/uploads/2020/01/stop-the-violence-against-women.jpg" />
                    <div className="honeycomb-cell__title">Women Safety DEPT.</div>
                </li>
                <li className="honeycomb-cell honeycomb__placeholder"></li>
            </ul>
        </div>



    );
}




export default Authority;