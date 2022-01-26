package edu.cmu.andrew.marangol.Project1Task1;

/*
 * @author Martin Arango (marangol)
 *
 * Copied code and comments from Lab 1
 * Copied comment structure from Lab 2
 * This file is the servlet acting as the controller
 * There are two views - index.jsp and result.jsp
 * It decides between the two by determining if there is an input string parameter or
 * not. If there is no parameter, then it uses the index.jsp view, as a
 * starting place. If there is a search parameter, then it computes the hash
 * and uses the result.jsp view.
 * The model is provided by ComputeHashModel.java.
 * To run project remember to change the deployment application context to:
 * /Project1Task1-1.0-SNAPSHOT
 */

import java.io.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ComputeHashes", value = "/computeHashes-servlet")
public class ComputeHashes extends HttpServlet {

    ComputeHashModel hashModel = null;  // The "business model" for this app

    // Initiate this servlet by instantiating the model that it will use.
    @Override
    public void init() {
        hashModel = new ComputeHashModel();
    }

    // This servlet will reply to HTTP GET requests via this doGet method
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String inputStr = request.getParameter("inputStr");
        String nextView;
        if (inputStr != null) {
            // Update hashModel parameters with the user inputs
            hashModel.setHashAlgorithm(request.getParameter("hashAlgorithm"));
            hashModel.setInputStr(inputStr);

            // use the model to compute hash
            hashModel.computeHash();
            // Echo results to console for debugging purposes
            System.out.println("The " + hashModel.getHashAlgorithm() + " Hash of " + hashModel.getInputStr() + " is " +
                    "Hex:" + hashModel.getHashHex() + " Base64:" + hashModel.getHashBase64());

            // Pass the user input string to the view
            request.setAttribute("input_str", hashModel.getInputStr());
            // Pass the selected hash algorithm to the view
            request.setAttribute("hash_algorithm", hashModel.getHashAlgorithm());
            // Pass the hash in hex to the view
            request.setAttribute("hash_hex", hashModel.getHashHex());
            // Pass the hash in Base64 to the view
            request.setAttribute("hash_base64", hashModel.getHashBase64());
            nextView = "result.jsp";
        } else {
            // no search parameter so choose the prompt index
            nextView = "index.jsp";
        }
        // Transfer control over the correct "view"
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextView);
        requestDispatcher.forward(request, response);
    }

}