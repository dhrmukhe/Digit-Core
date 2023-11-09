package digit.web.controllers;


import digit.service.BoundaryHierarchyDefinitionService;
import digit.service.BoundaryRelationshipService;
import digit.service.BoundaryService;
import digit.web.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-10-16T17:02:11.361704+05:30[Asia/Kolkata]")
@Controller
@RequestMapping("")
public class BoundaryApiController {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final BoundaryService boundaryService;

    private final BoundaryHierarchyDefinitionService boundaryHierarchyDefinitionService;

    private final BoundaryRelationshipService boundaryRelationshipService;

    @Autowired
    public BoundaryApiController(ObjectMapper objectMapper, HttpServletRequest request, BoundaryService boundaryService,
                                 BoundaryHierarchyDefinitionService boundaryHierarchyDefinitionService, BoundaryRelationshipService boundaryRelationshipService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.boundaryService = boundaryService;
        this.boundaryHierarchyDefinitionService = boundaryHierarchyDefinitionService;
        this.boundaryRelationshipService = boundaryRelationshipService;
    }

    @RequestMapping(value = "/boundary/boundary-relationships/_create", method = RequestMethod.POST)
    public ResponseEntity<BoundaryRelationshipResponse> boundaryBoundaryRelationshipsCreatePost(@Valid @RequestBody BoundaryRelationshipRequest body) {
        BoundaryRelationshipResponse boundaryRelationshipResponse = boundaryRelationshipService.createBoundaryRelationship(body);
        return new ResponseEntity<BoundaryRelationshipResponse>(boundaryRelationshipResponse, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/boundary/boundary-relationships/_search", method = RequestMethod.POST)
    public ResponseEntity<BoundarySearchResponse> boundaryBoundaryRelationshipsSearchPost(@Valid @ModelAttribute BoundaryRelationshipSearchCriteria boundaryRelationshipSearchCriteria, @RequestBody RequestInfo requestInfo) {
        BoundarySearchResponse boundarySearchResponse = boundaryRelationshipService.getBoundaryRelationships(boundaryRelationshipSearchCriteria);
        return new ResponseEntity<BoundarySearchResponse>(boundarySearchResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/boundary/boundary-relationships/_update", method = RequestMethod.POST)
    public ResponseEntity<BoundaryRelationshipResponse> boundaryBoundaryRelationshipsUpdatePost(@Valid @RequestBody BoundaryRelationshipRequest body) {
        BoundaryRelationshipResponse boundaryRelationshipResponse = boundaryRelationshipService.updateBoundaryRelationship(body);
        return new ResponseEntity<BoundaryRelationshipResponse>(boundaryRelationshipResponse, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/boundary/_create", method = RequestMethod.POST)
    public ResponseEntity<BoundaryResponse> boundaryCreatePost(@Valid @RequestBody BoundaryRequest body) {
        BoundaryResponse boundaryResponse = boundaryService.createBoundary(body);
        return new ResponseEntity<BoundaryResponse>(boundaryResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/boundary/boundary-hierarchy-definition/_create", method = RequestMethod.POST)
    public ResponseEntity<BoundaryTypeHierarchyResponse> boundaryHierarchyDefinitionCreatePost(@Valid @RequestBody BoundaryTypeHierarchyRequest body) {
        BoundaryTypeHierarchyResponse boundaryTypeHierarchyResponse = boundaryHierarchyDefinitionService.createBoundaryHierarchyDefinition(body);
        return new ResponseEntity<BoundaryTypeHierarchyResponse>(boundaryTypeHierarchyResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/boundary/boundary-hierarchy-definition/_search", method = RequestMethod.POST)
    public ResponseEntity<BoundaryTypeHierarchyResponse> boundaryHierarchyDefinitionSearchPost(@Valid @RequestBody BoundaryTypeHierarchySearchRequest body) {
        BoundaryTypeHierarchyResponse boundaryTypeHierarchyResponse = boundaryHierarchyDefinitionService.searchBoundaryHierarchyDefinition(body);
        return new ResponseEntity<BoundaryTypeHierarchyResponse>(boundaryTypeHierarchyResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/boundary/_search", method = RequestMethod.POST)
    public ResponseEntity<BoundaryResponse> boundarySearchPost(@Valid @ModelAttribute BoundarySearchCriteria boundarySearchCriteria, @RequestBody RequestInfo requestInfo) {
        BoundaryResponse boundaryResponse = boundaryService.searchBoundary(boundarySearchCriteria,requestInfo);
        return new ResponseEntity<BoundaryResponse>(boundaryResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/boundary/_update", method = RequestMethod.POST)
    public ResponseEntity<BoundaryResponse> boundaryUpdatePost(@Valid @RequestBody BoundaryRequest body) {
        BoundaryResponse boundaryResponse = boundaryService.updateBoundary(body);
        return new ResponseEntity<BoundaryResponse>(boundaryResponse,HttpStatus.OK);
    }

}
