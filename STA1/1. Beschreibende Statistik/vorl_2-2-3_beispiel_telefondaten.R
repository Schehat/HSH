# Generating 5000 (= 1650 + 1111 + 720 + 508 + 332 + 427 + 252) random data points
minutes = c(runif(1650, 0, 2), runif(1111, 2, 4), runif(720, 4, 6),
            runif(508, 6, 8), runif(332, 8, 10), runif(427, 10, 15), runif(252, 15, 30))

breaks = c(0, 2, 4, 6, 8, 10, 15, 30)

bins <- cut(minutes, breaks)

absfreqs <- table(bins)
print(absfreqs)

relfreqs <- absfreqs / 5000
print(relfreqs)

hist(minutes, breaks=breaks, col=c("#FF7046"), main="",
     xlab=expression(a[j]), ylab=expression(f[j]/d[j]))

print(cumsum(relfreqs))
