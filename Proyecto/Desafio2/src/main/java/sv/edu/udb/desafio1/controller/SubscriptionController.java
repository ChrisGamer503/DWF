package sv.edu.udb.desafio1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.desafio1.dto.SubscriptionDTO;
import sv.edu.udb.desafio1.model.Subscription;
import sv.edu.udb.desafio1.service.SubscriptionService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    @Operation(summary = "Get all subscriptions", description = "Retrieve all subscriptions")
    public ResponseEntity<List<Subscription>> getAll() {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

    @GetMapping("/paged")
    @Operation(summary = "Get subscriptions with pagination", description = "Retrieve subscriptions with pagination and sorting")
    public ResponseEntity<Page<Subscription>> getSubscriptionsPaged(Pageable pageable) {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptionsPaged(pageable));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get subscriptions by user", description = "Retrieve all subscriptions for a given user ID")
    public ResponseEntity<List<Subscription>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionsByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create subscription", description = "Create a new subscription for a user")
    public ResponseEntity<Subscription> create(@Valid @RequestBody SubscriptionDTO dto) {
        Subscription created = subscriptionService.createSubscription(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update subscription", description = "Update subscription by ID")
    public ResponseEntity<Subscription> update(@PathVariable Long id, @Valid @RequestBody SubscriptionDTO dto) {
        Subscription updated = subscriptionService.updateSubscription(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete subscription", description = "Delete subscription by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}
