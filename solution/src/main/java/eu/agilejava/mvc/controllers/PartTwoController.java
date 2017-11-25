/*
 * The MIT License
 *
 * Copyright 2015 Ivar Grimstad (ivar.grimstad@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.agilejava.mvc.controllers;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.event.BeforeControllerEvent;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Path("part-2")
@Controller
public class PartTwoController {

    @Inject
    private Models model;

    @Inject
    private MvcContext mvc;

    @GET
    public String view() {
        return "form.jsp";
    }

    @CsrfValid
    @POST
    public String hello(@FormParam("name") String name) {

        String language = mvc.getLocale().getLanguage();
        
        model.put("message", "Hello " + name + " in " + language );
        return "hello.jsp";
    }
    // return form.jsp from @GET
    // @POST method with form param name
    // add models
    // add csrf
    // locale
    // events
    
    public void log(@Observes BeforeControllerEvent bce) {
        System.out.println("Before Controller " + bce.getUriInfo().getAbsolutePath().getPath());
    }
}
