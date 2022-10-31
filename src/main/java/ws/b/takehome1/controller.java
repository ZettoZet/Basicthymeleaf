/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.takehome1;

import java.io.IOException;
import java.sql.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ToRo
 */
@Controller
public class controller {
    @RequestMapping(value="/Biodata", method=RequestMethod.POST)
    public String getData(@RequestParam(value="nama") String fname,
                          @RequestParam(value="tanggal") Date tgl,
                          @RequestParam(value="foto") MultipartFile pht,
                           Model model) throws IOException{

        byte[] getdata = pht.getBytes();
        String base64Image = Base64.encodeBase64String(getdata);
        String getdatalink ="data:image/png;base64,".concat(base64Image);

        model.addAttribute("namal", fname);
        model.addAttribute("tanggal", tgl);
        model.addAttribute("foto", getdatalink);
        
        return"main";
    }

}
