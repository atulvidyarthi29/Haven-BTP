import React, { useState } from "react";
import "../elements/main.css";
// import "../elements/util.css";
import { useSpeechRecognition } from 'react-speech-kit';



function PostForm(){

    const [value, setValue] = useState('');
    const { listen, listening, stop } = useSpeechRecognition({
      onResult: (result) => {
        setValue(result);
      },
    });
    return(
        
        <div className="container-contact100">
            
        <div className="wrap-contact100">
            <form className="contact100-form">
                <span className="contact100-form-title">
                    Report an incident
                </span>

                <label className="label-input100" for="first-name">City     State</label>
                <div className="wrap-input100 rs1-wrap-input100 " >
                    <input id="City" className="input100" type="text" name="City" placeholder="First name"/>
                    <span className="focus-input100"></span>
                </div>
                <div className="wrap-input100 rs2-wrap-input100 " >
                    <input className="input100" type="text" name="State" placeholder="State"/>
                    <span className="focus-input100"></span>
                </div>

                <label className="label-input100" for="email">Headline</label>
                <div className="wrap-input100 " >
                    <input id="email" className="input100" type="text" name="email" placeholder="Eg. example@email.com"/>
                    <span className="focus-input100"></span>
                </div>

                <label className="label-input100" for="phone">Enter phone number</label>
                <div className="wrap-input100">
                    <input id="phone" className="input100" type="text" name="phone" placeholder="Eg. +1 800 000000"/>
                    <span className="focus-input100"></span>
                </div>

                <label className="label-input100" for="message">Content*
                
                
                </label>
                
      

                <div className="wrap-input100 ">
                    
                    
                
                
      <textarea className="input100" id="message" name="value"
        value={value}
        onChange={(event) => setValue(event.target.value)
        }
        
      />
      <p onMouseDown={listen} onMouseUp={stop}>
        🎤Speak
      </p>
      {listening && <div>Go ahead I'm listening</div>}
    
                    <span className="focus-input100"></span>
                </div>

                <div className="container-contact100-form-btn">
                    <button className="contact100-form-btn">
                        Submit
                    </button>
                </div>
            </form>

            <div className="contact100-more flex-col-c-m" >
            <div className="container_blog2">
                
                <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="300">
              POST - <span className="text-color-primary">HAVEN</span>
            </h1>       </center>
            </div>
            <div className="container_blog2">
                
                <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="300">
              _____<span className="text-color-primary">________</span>
            </h1>       </center>
            <center>
                <h1 className="mt-0 mb-16 reveal-from-bottom" data-reveal-delay="300">
              WE<span className="text-color-primary">CARE.</span>
            </h1>       </center>
            </div>
                <div className="flex-w size1 p-b-47">
                    <div className="txt1 p-r-25">
                        <span className="lnr lnr-map-marker"></span>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
       
    );
    
}



  
export default PostForm;