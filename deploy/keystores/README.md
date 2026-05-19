# Core Ledger Keystores

| File | Type | Algorithm | Rotation | Notes |
|---|---|---|---|---|
| `prod-signing.p12` | PKCS#12 | RSA-2048 / SHA-1 | 365d | Production JWT signing |
| `partner-mtls.p12` | PKCS#12 | RSA-2048 / SHA-256 | 365d | Partner bank mTLS |
| `legacy-fx.jks` | JKS | RSA-1024 / SHA-1 | NEVER | Legacy FX trading endpoint — slated for retirement Q4 2026 |
| `wire-transfer.p12` | PKCS#12 | RSA-2048 / SHA-256 | 90d | SWIFT MT103 signing |

All keystores are stored in Vault at `secret/data/core-ledger/keystores/<name>`.
Master passphrase rotation: every 30 days via `rotate_keystore_passphrase.sh`.

⚠️ `legacy-fx.jks` is RSA-1024 + SHA-1 — flagged in 2023 audit but production
SLA prevents rotation until partner upgrade lands (TICK-3104).
