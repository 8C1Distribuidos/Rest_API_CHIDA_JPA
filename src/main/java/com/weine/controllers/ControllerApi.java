package com.weine.controllers;

import com.weine.services.IServiceApi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Abstract class to manage the request of the clients in a generic form and works as template for a <b>Controller Class</b>,<br>
 * <b>GET</b> to obtain a list of objects. {@link #doGet(HttpServletRequest, HttpServletResponse)}.<br>
 *  <b>POST</b> to save one object. {@link #doPost(HttpServletRequest, HttpServletResponse)}.<br>
 * <b>PUT</b> to update one object. {@link #doPut(HttpServletRequest, HttpServletResponse)}.<br>
 * <b>DELETE</b> to delete one object. {@link #doDelete(HttpServletRequest, HttpServletResponse)}.<br>
 * Also to use those methods and appears in the controllers must to override, add the correct beans and in the constructor must to call the super
 * constructor and initialize the logger e.g.<br>
 * <pre>{@code
 *      //The controller beans
 *      @RestController
 *      @RequestMapping("/example")
 *      public class ExampleController extends ControllerApi<ExampleDto, ExampleCriteria, ExampleService>{
 *          public ExampleController(IServiceApi<ExampleDto, ExampleCriteria> service) {
 *              super(service);
 *              //The initialization of the logger
 *              this.logger = LoggerFactory.getLogger(ExampleController.class);
 *          }
 *          //The get mapping bean
 *          @GetMapping
 *          @Override
 *          public ResponseEntity<Page<ExampleDto>> getPage(PageProp pageProp, ExampleCriteria criteria) {
 *              return super.getPage(pageProp, criteria);
 *          }
 *     }
 * }</pr>
 * @param <D> The Data dto type
 * @param <C> The CriteriaSearch type
 * @param <S> The Service type with the previous types
 * @author Luis
 * @since BACKEND_BD-0.1
 * @version 1.0
 */
public abstract class ControllerApi<D,C, S extends IServiceApi<D,C>> extends HttpServlet {
    protected IServiceApi<D,C> service;

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    /**
     * To get individual item
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Obtaining All "+ getEntityPluralName()+ "...");
        List<D> response = this.service.getObjects();
        for (D object: response) {
            resp.getWriter().write(object.toString());
        }
        resp.setStatus(200);
        System.out.println( getEntityPluralName()+ " obtained...");
    }


    /**
     * Function to get the request of the client in a <b>POST</b> form.<br>
     * This request is to <b>save</b> the object in the database.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = getBody(req);
        System.out.println("Save " + getEntityName() + "" + string + "...");
        System.out.println(getEntityName() + " saved...");
        resp.getWriter().write(string);
        /*
        try{
            D response = this.service.save(requestObject);
            if(response == null)
            {
                logger.warn(getEntityName() + " " + requestObject + " has not been saved");
                throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
            }
            logger.info(getEntityName() + " " + response + " saved...");
            return ResponseEntity.ok(response);
        }catch (RuntimeException e)
        {
            logger.error(e.getMessage());
            logger.warn(getEntityName() + " " + requestObject + " has not been saved");
            throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
        }
         */
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = getBody(req);
        System.out.println("Update " + getEntityName() + "" + string + "...");
        System.out.println(getEntityName() + " updated...");
        resp.getWriter().write(string);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println("Delete " + getEntityName() + " " + id+ "...");
        try {
            this.service.delete(id);
        }catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
            System.out.println(getEntityName() + " " + id + " has not been deleted");
            resp.sendError(404, "No " + getEntityName() + " " + id + " exist");
        }
        resp.setStatus(200);
        System.out.println(getEntityName() + " " + id +" deleted...");
    }

    /**
     * Function to get the name of the entity
     * @return The Entity name
     */
    protected abstract String getEntityName();
    /**
     * Function to get the name of the entity in plural form
     * @return The Entity plural name
     */
    protected abstract String getEntityPluralName();
}
